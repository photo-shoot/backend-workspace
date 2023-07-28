package photoshoot.backendworkspace.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("main")
public class MainPageController {

    @GetMapping("/studio/top3")
    public ResponseEntity<?> studioTop3(){
        return ResponseEntity.badRequest().body("아직 준비되지 않은 서비스입니다.");
    }

    @GetMapping("/photographer/top3")
    public ResponseEntity<?> photographerTop3(){
        return ResponseEntity.badRequest().body("아직 준비되지 않은 서비스입니다.");
    }
}
