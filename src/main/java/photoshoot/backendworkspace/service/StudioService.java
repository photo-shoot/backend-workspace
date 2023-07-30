package photoshoot.backendworkspace.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import photoshoot.backendworkspace.entity.Studio;
import photoshoot.backendworkspace.repository.StudioRepository;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class StudioService {
    private final StudioRepository studioRepository;

    public List<Studio> listStudio(){
        return studioRepository.findAll();
    }


}
