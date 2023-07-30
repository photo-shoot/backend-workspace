package photoshoot.backendworkspace.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import photoshoot.backendworkspace.entity.Studio;
import photoshoot.backendworkspace.service.StudioService;

import java.util.List;

@Slf4j
@RestController
public class StudioController {

    @Autowired
    StudioService studioService;

    // 나중에 util로 빼기
    @GetMapping("/studio/hot3")
    public ResponseEntity<?> studioHot3(){
        return ResponseEntity.badRequest().body("아직 구현되지 않은 서비스입니다.");
    }

    @GetMapping("/studios")
    public ResponseEntity<?> listStudios() {
        List<Studio> studioList = studioService.listStudio();
        return ResponseEntity.ok().body(studioList);
    }

}
