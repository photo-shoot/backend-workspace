package photoshoot.backendworkspace.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import photoshoot.backendworkspace.dto.photographer.PhotographerListResponseDTO;
import photoshoot.backendworkspace.service.PhotographerService;

@Slf4j
@Controller
@Tag(name="Photographer api")
public class PhotographerController {
    @Autowired
    PhotographerService photographerService;

    // 나중에 util로 빼기
    @GetMapping("/photographer/hot3")
    public ResponseEntity<?> photographerHot3(){
        return ResponseEntity.badRequest().body("아직 구현되지 않은 서비스입니다.");
    }

    @Operation(summary = "사작가 전체 리스트(아직 필터 적용 X)", description = "사진작가 전체 리스트 조회 api입니다.")
    @GetMapping("/photographers")
    public ResponseEntity<?> listPhotographers(
            @Parameter(description = "n번째 페이지") @RequestParam(name = "pageNo", defaultValue = "0", required = false) int pageNo,
            @Parameter(description = "한 페이지에 불러올 사진작가 개수") @RequestParam(name = "pageSize", defaultValue = "8", required = false) int pageSize
            //@RequestParam(name = "filter", defaultValue = "0", required = false) String filter
    ){
        PhotographerListResponseDTO photographerListResponse = photographerService.listPhotographer(pageNo, pageSize);
        return ResponseEntity.ok().body(photographerListResponse);
    }

    @Operation(summary = "사진작가 카테고리별 리스트(아직XXXX)", description = "카테고리별 사진작가 리스트 불러오는 api입니다.")
    @GetMapping("/photographers/{category}")
    public ResponseEntity<?> listCategoryPhotographers(
            @Parameter(description = "n번째 페이지") @RequestParam(name = "pageNo", defaultValue = "0", required = false) int pageNo,
            @Parameter(description = "한 페이지에 불러올 사진작가 개수") @RequestParam(name = "pageSize", defaultValue = "0", required = false) int pageSize
            //@RequestParam(name = "category", defaultValue = "0", required = false) String category,
            //@RequestParam(name = "filter", defaultValue = "0", required = false) String filter
    ){
        PhotographerListResponseDTO photographerListResponse = photographerService.listPhotographer(pageNo, pageSize);
        return ResponseEntity.ok().body(photographerListResponse);
    }
}
