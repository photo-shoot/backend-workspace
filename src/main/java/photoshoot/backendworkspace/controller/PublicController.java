package photoshoot.backendworkspace.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import photoshoot.backendworkspace.dto.signup.SignupRequestDTO;

@Slf4j
@RestController
@RequestMapping("/public")
public class PublicController {

    @GetMapping("/studio/hot3")
    public ResponseEntity<?> studioHot3(){
        return ResponseEntity.badRequest().body("아직 구현되지 않은 서비스입니다.");
    }

    @GetMapping("/photographer/hot3")
    public ResponseEntity<?> photographerHot3(){
        return ResponseEntity.badRequest().body("아직 구현되지 않은 서비스입니다.");
    }
}
