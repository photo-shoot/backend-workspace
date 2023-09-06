package photoshoot.backendworkspace.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import photoshoot.backendworkspace.dto.sign.SigninRequestDTO;
import photoshoot.backendworkspace.dto.sign.SignupRequestDTO;
import photoshoot.backendworkspace.service.SignService;

@Slf4j
@RestController
@Tag(name = "Sign api", description = "회원가입, 로그인 관련 api입니다.")
public class SignController {

    @Autowired
    SignService signService;

    @Operation(summary = "이메일 회원가입", description = "이메일 회원가입 api입니다.")
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequestDTO dto){
        return signService.signup(dto);
    }

    @GetMapping("/signin/oauth/naver/callback")
    public ResponseEntity<?> signinNaver(){
        return ResponseEntity.ok().body("naver oauth signin!");
    }
}
