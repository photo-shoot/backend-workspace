package photoshoot.backendworkspace.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import photoshoot.backendworkspace.entity.Photographer;
import photoshoot.backendworkspace.service.PhotographerService;

import java.util.List;

@Slf4j
@Controller
public class PhotographerController {
    @Autowired
    PhotographerService photographerService;

    // 나중에 util로 빼기
    @GetMapping("/photographer/hot3")
    public ResponseEntity<?> photographerHot3(){
        return ResponseEntity.badRequest().body("아직 구현되지 않은 서비스입니다.");
    }

    @GetMapping("/photographers")
    public ResponseEntity<?> listPhotographers(){
        List<Photographer> photographerList = photographerService.listPhotographer();
        return ResponseEntity.ok().body(photographerList);
    }
}
