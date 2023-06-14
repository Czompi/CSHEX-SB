package hu.czsoft.cshex_sb.controllers;

import hu.czsoft.cshex_sb.models.ApiVersion;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class AppInfoController {

    @GetMapping
    public ResponseEntity getApiInfo() {
        return ResponseEntity.ok(new ApiVersion());
    }
}
