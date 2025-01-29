package controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import service.CabLocationService;

@RestController
@RequestMapping("/location")
public class CabLocationController {

    @Autowired
    private CabLocationService cabLocationService;

    @PutMapping
    public ResponseEntity<Map<String, String>> updateLocation() {
        int range = 100;
        while (range > 0) {
            // Update the location with random latitude and longitude values
            cabLocationService.updateLocation(Math.random() + "," + Math.random());

            try {
                // Pause execution for 1 second
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // Log the error (replace with a logger in a real-world scenario)
                e.printStackTrace();
                // Optionally, return an error response if interruption occurs
                return new ResponseEntity<>(
                        Map.of("message", "Location update interrupted"), 
                        HttpStatus.INTERNAL_SERVER_ERROR
                );
            }

            range--;
        }

        // Return success response
        return new ResponseEntity<>(
                Map.of("message", "Location updated successfully"), 
                HttpStatus.OK
        );
    }
}
