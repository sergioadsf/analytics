package br.com.analytics.entity;

import java.io.Serializable;

public abstract class Entidade<S extends Serializable> implements Serializable {

	private static final long serialVersionUID = -6879250781879980342L;

	public abstract S getId();

	public abstract void setId(S id);

}
