package com.pluralsight.conference_demo.controllers;

import com.pluralsight.conference_demo.models.Speaker;
import com.pluralsight.conference_demo.repositories.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/speakers")
public class SpeakersController {
    @Autowired
    private SpeakerRepository speakerRepository;

    @GetMapping
    public List<Speaker> list()
    {
        return speakerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Speaker get(@PathVariable Long id)
    {
        return speakerRepository.getOne(id);
    }

    @PostMapping
    public Speaker create(@RequestBody final Speaker speaker)
    {
        return speakerRepository.saveAndFlush(speaker);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id)
    {
        speakerRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker)
    {
        Speaker existingSpeaker = speakerRepository.getOne(id);
        BeanUtils.copyProperties(speaker, existingSpeaker, "speaker_id");
        return speakerRepository.saveAndFlush(existingSpeaker);
    }


}
