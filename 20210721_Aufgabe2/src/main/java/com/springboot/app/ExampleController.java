package com.springboot.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.springboot.app.objects.ExampleResponse;

@RestController	
public class ExampleController {

	@GetMapping("/helloworld")
	public String welcome() {
		return "Hello World";
	}
	
	@GetMapping("/text/analyze")
	@ResponseBody
	public String Aufgabe2( @RequestBody String Produktdata ) {
		
		JsonArray tmp = new JsonParser().parse(Produktdata).getAsJsonArray();
		ExampleResponse Response = new ExampleResponse(tmp);
		return Response.Analyze().toString();
	}
}
