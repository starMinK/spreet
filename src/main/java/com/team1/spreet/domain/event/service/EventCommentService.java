package com.team1.spreet.domain.event.service;

import com.team1.spreet.domain.admin.service.BadWordService;
import com.team1.spreet.domain.alarm.service.AlarmService;
import com.team1.spreet.domain.event.dto.EventCommentDto;
import com.team1.spreet.domain.event.model.Event;
import com.team1.spreet.domain.event.model.EventComment;
import com.team1.spreet.domain.event.repository.EventCommentRepository;
import com.team1.spreet.domain.event.repository.EventRepository;
import com.team1.spreet.domain.user.model.User;
import com.team1.spreet.domain.user.model.UserRole;
import com.team1.spreet.global.error.exception.RestApiException;
import com.team1.spreet.global.error.model.ErrorStatusCode;
import com.team1.spreet.global.util.SecurityUtil;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EventCommentService {

	private final EventRepository eventRepository;
	private final EventCommentRepository eventCommentRepository;
	private final AlarmService alarmService;
	private final BadWordService badWordService;

	public void saveEventComment(Long eventId, EventCommentDto.RequestDto requestDto) {
		User user = SecurityUtil.getCurrentUser();
		if (user == null) {
			throw new RestApiException(ErrorStatusCode.NOT_EXIST_AUTHORIZATION);
		}

		Event event = checkEvent(eventId);

		String content = badWordService.checkBadWord(requestDto.getContent());
		eventCommentRepository.saveAndFlush(
			requestDto.toEntity(content, event, user));

		if (!event.getUser().getId().equals(user.getId())) {
			alarmService.send(user.getId(),
				"💬" + event.getUser().getNickname() + "님! " + "작성하신 행사 정보에 댓글 알림이 도착했어Yo!\n",
				"https://www.spreet.co.kr/api/event/" + event.getId(), event.getUser().getId());
		}
	}

	public void updateEventComment(Long commentId, EventCommentDto.RequestDto requestDto) {
		User user = SecurityUtil.getCurrentUser();
		if (user == null) {
			throw new RestApiException(ErrorStatusCode.NOT_EXIST_AUTHORIZATION);
		}

		EventComment eventComment = checkEventComment(commentId);

		if (!user.getId().equals(eventComment.getUser().getId())) {
			throw new RestApiException(ErrorStatusCode.UNAVAILABLE_MODIFICATION);
		}

		String content = badWordService.checkBadWord(requestDto.getContent());
		eventComment.updateEventComment(content);
		eventCommentRepository.saveAndFlush(eventComment);
	}

	public void deleteEventComment(Long commentId) {
		User user = SecurityUtil.getCurrentUser();
		if (user == null) {
			throw new RestApiException(ErrorStatusCode.NOT_EXIST_AUTHORIZATION);
		}

		EventComment eventComment = checkEventComment(commentId);

		if (!user.getUserRole().equals(UserRole.ROLE_ADMIN) && !user.getId().equals(eventComment.getUser().getId())) {
			throw new RestApiException(ErrorStatusCode.UNAVAILABLE_MODIFICATION);
		}
		eventComment.isDeleted();
		eventCommentRepository.saveAndFlush(eventComment);
	}

	@Transactional(readOnly = true)
	public List<EventCommentDto.ResponseDto> getEventCommentList(Long eventId) {
		checkEvent(eventId);

		return eventCommentRepository.findAllByEventId(eventId);
	}

	private EventComment checkEventComment(Long commentId) {
		return eventCommentRepository.findByIdAndDeletedFalseWithUser(commentId).orElseThrow(
			() -> new RestApiException(ErrorStatusCode.NOT_EXIST_COMMENT)
		);
	}

	private Event checkEvent(Long eventId) {
		return eventRepository.findByIdAndDeletedFalse(eventId).orElseThrow(
			() -> new RestApiException(ErrorStatusCode.NOT_EXIST_EVENT)
		);
	}

}