package br.com.analytics.controller;

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
import br.com.analytics.dto.DashboardDTO;
import br.com.analytics.google.v3.Connection;
import br.com.analytics.google.v3.GAccount;
import br.com.analytics.google.v3.GProfile;
import br.com.analytics.google.v3.GWebProperties;
import br.com.analytics.google.v3.model.ParamsDTO;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("dashboard")
public class DashboardController extends BaseController<DashboardDTO> {

	@SuppressWarnings("unchecked")
	@Async
	@PostMapping(path = "/listAccounts", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public Response<DashboardDTO> listAccounts(@RequestBody String token) {

		try {
			return success(GAccount.start(token).accounts().getAccounts());
		} catch (Exception e) {
			return fail(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Async
	@PostMapping(path = "/listWebProperties", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public Response<DashboardDTO> listWebProperties(@RequestBody String paramsStr) {

		try {
			ParamsDTO params = convert(ParamsDTO.class, paramsStr);
			return success(
					GWebProperties.start(params.getToken()).webproperties(params.getIdAccount()).getWebProperties());
		} catch (Exception e) {
			return fail(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Async
	@PostMapping(path = "/listProfiles", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public Response<DashboardDTO> listProfiles(@RequestBody String paramsStr) {

		try {
			ParamsDTO params = convert(ParamsDTO.class, paramsStr);
			return success(GProfile.start(params.getToken()).profiles(params.getIdAccount(), params.getIdWebProperty())
					.getProfiles());
		} catch (Exception e) {
			return fail(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Async
	@PostMapping(path = "/tokenResponse", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public Response<DashboardDTO> tokenResponse(@RequestBody String token) {

		try {
			return success(Connection.getTokenResponse(token));
		} catch (Exception e) {
			return fail(e.getMessage());
		}
	}

}
