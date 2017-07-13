package br.com.analytics;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class BaseController<E> {

	protected Response<E> enviarSucesso() {

		return new Response<E>(true);
	}

	protected Response<E> fail(String msg) {

		return new Response<E>(false, msg);
	}

	@SuppressWarnings("rawtypes")
	protected <T extends Object> Response success(T objetoRetorno) {

		return new Response<T>(true, objetoRetorno);
	}

	protected <T extends Object> T convert(Class<T> clazz, String str) {

		return new Gson().fromJson(str, clazz);
	}

	protected <T extends Object> T convert(String str, TypeToken<T> typeToken) {

		return new Gson().fromJson(str, typeToken.getType());
	}
}
