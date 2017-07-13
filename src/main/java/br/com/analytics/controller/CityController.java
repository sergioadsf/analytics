package br.com.analytics.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.analytics.BaseController;
import br.com.analytics.Response;
import br.com.analytics.google.v3.GACity;
import br.com.analytics.google.v3.model.CityDTO;
import br.com.analytics.google.v3.model.ParamsDTO;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("city")
public class CityController extends BaseController<List<CityDTO>> {

	@SuppressWarnings("unchecked")
	@Async
	@PostMapping(path = "/listCity", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public Response<List<CityDTO>> listCity(@RequestBody String paramsStr) {

		try {
			ParamsDTO params = convert(ParamsDTO.class, paramsStr);

			if (params == null) {
				throw new Exception("Improve After");
			}

			return success(GACity.start(params).city().execute());
		} catch (Exception e) {
			return fail(e.getMessage());
		}
	}

}
