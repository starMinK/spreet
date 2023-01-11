package com.team1.spreet.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.team1.spreet.dto.CustomResponseBody;
import com.team1.spreet.dto.UserDto;
import com.team1.spreet.entity.UserRole;
import com.team1.spreet.exception.ErrorStatusCode;
import com.team1.spreet.exception.RestApiException;
import com.team1.spreet.repository.UserRepository;
import com.team1.spreet.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "user")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
@Slf4j
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @ApiOperation(value = "회원가입 API")
    @PostMapping("/signup")
    public CustomResponseBody signup(@RequestBody @Valid final UserDto.SignupRequestDto requestDto) {
        log.info("requestDto : " + requestDto);
        return userService.signup(requestDto);
    }

    @ApiOperation(value = "로그인 API")
    @PostMapping("/login")
    public CustomResponseBody login(@RequestBody final UserDto.LoginRequestDto requestDto, HttpServletResponse httpServletResponse) {
        // 크루 승인 대기 중인 유저는 로그인 불가
        if (userRepository.existsByLoginIdAndUserRoleAndIsCrew(requestDto.getLoginId(), UserRole.ROLE_CREW, false)) {
            throw new RestApiException(ErrorStatusCode.WAITING_CREW_APPROVAL);
        }
        return userService.login(requestDto, httpServletResponse);
    }

    //소셜 로그인 추가 예정!
    @ApiOperation(value = "카카오 로그인 API")
    @GetMapping("/kakao/callback")
    public CustomResponseBody kakaoLogin(@RequestParam String code, HttpServletResponse httpServletResponse) throws JsonProcessingException {
        return userService.kakaoLogin(code, httpServletResponse);
    }
}
