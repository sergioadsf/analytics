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
import br.com.analytics.google.v3.GAReferTraffic;
import br.com.analytics.google.v3.model.ReferTrafficDTO;
import br.com.analytics.google.v3.model.ParamsDTO;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("referTraffic")
public class ReferTrafficController extends BaseController<List<ReferTrafficDTO>> {

	@SuppressWarnings("unchecked")
	@Async
	@PostMapping(path = "/listReferTraffic", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public Response<List<ReferTrafficDTO>> listReferTraffic(@RequestBody String paramsStr) {

		try {
			ParamsDTO params = convert(ParamsDTO.class, paramsStr);

			if (params == null) {
				throw new Exception("Improve After");
			}

			return success(GAReferTraffic.start(params).referTraffic().execute());
		} catch (Exception e) {
			return fail(e.getMessage());
		}
	}

}
