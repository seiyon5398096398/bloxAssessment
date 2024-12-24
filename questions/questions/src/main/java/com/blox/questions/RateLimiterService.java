package com.blox.questions;

import java.util.LinkedList;
import java.util.Queue;

import org.springframework.stereotype.Service;

@Service
public class RateLimiterService {
	
	private static final int MAX_CALLS_PER_MINUTE = 15;
    //penalty time - 1min

    private Queue<Long> callTimestamps = new LinkedList<>();
    private long penaltyEndTime = 0;

    public String callApi(String input) {
        long currentTime = System.currentTimeMillis();

        if (currentTime < penaltyEndTime) {
            long waitTime = penaltyEndTime - currentTime;
            try {
                Thread.sleep(waitTime); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        while (!callTimestamps.isEmpty() && currentTime - callTimestamps.peek() > 60000) {
            callTimestamps.poll();
        }

        if (callTimestamps.size() >= MAX_CALLS_PER_MINUTE) {
            penaltyEndTime = currentTime + 60000; // add 1 minute
            return "Rate limit exceeded. Penalty applied.";
        }

        callTimestamps.add(currentTime);
        return callMe(input);
    }

    private String callMe(String input) {
        return "Hello you called me with input: " + input;
    }

}
