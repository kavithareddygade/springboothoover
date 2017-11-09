package com.yoti.robotichoover;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoboticHooverController {
    private static Logger log = LoggerFactory.getLogger(RoboticHooverController.class);
    private RoboticHooverService roboticHooverService;

    @Autowired
    public RoboticHooverController(RoboticHooverService roboticHooverService) {
        this.roboticHooverService = roboticHooverService;
    }

    @RequestMapping(value = "/robotichoover", method = RequestMethod.POST)
    public ResponseEntity<HooverOutput> hoover(@RequestBody HooverInput hooverInput) {
        log.debug("Hoover Request received: " + hooverInput.getRoomSize() + " " + hooverInput.getCoords() + " " + hooverInput.getPatches() + " " + hooverInput.getInstructions());
        HooverOutput hooverOutput =  roboticHooverService.hoover(hooverInput);
        return new ResponseEntity<HooverOutput>(hooverOutput, HttpStatus.OK);
    }
}
