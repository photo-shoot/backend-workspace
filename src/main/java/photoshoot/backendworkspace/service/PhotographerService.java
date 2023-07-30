package photoshoot.backendworkspace.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import photoshoot.backendworkspace.entity.Photographer;
import photoshoot.backendworkspace.repository.PhotographerRepository;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class PhotographerService {

    private final PhotographerRepository photographerRepository;

    public List<Photographer> listPhotographer(){
        return photographerRepository.findAll();
    }
}
