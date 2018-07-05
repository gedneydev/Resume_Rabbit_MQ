package com.alliant.listner.controller;

import com.alliant.listner.data.co.VideoResumeCommand;
import com.alliant.listner.service.VideoResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.message.AuthException;
import javax.validation.Valid;

@RestController()
public class VideoResumeController {

    @Autowired private VideoResumeService videoResumeService;

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Object updateResumeVideo( @Valid @RequestBody VideoResumeCommand command) throws AuthException {
        return new ResponseEntity<Object>(videoResumeService.saveUpdate(command), HttpStatus.OK);
    }

    @ExceptionHandler()
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> invalidArguments(MethodArgumentNotValidException e) {
        return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = AuthException.class)
    public ResponseEntity<Object> authExceptionHandler(AuthException e){
        return new ResponseEntity<Object>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}
