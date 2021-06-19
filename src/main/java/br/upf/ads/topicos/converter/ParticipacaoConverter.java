package br.upf.ads.topicos.converter;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;

import br.upf.ads.topicos.entities.ModalidadeSubEvento;
import br.upf.ads.topicos.entities.Participacao;
import br.upf.ads.topicos.jpa.JpaUtil;

@FacesConverter(value = "participacaoConverter")
public class ParticipacaoConverter implements Converter{

	public Participacao getAsObject1(FacesContext fc, UIComponent uic, String value) {
		if (value != null && value.trim().length() > 0) {
			try {
				EntityManager em = JpaUtil.getInstance().getEntityManager();
				Participacao ret = em.find(Participacao.class, Long.parseLong(value));
				em.close();
				return ret;
			} catch (NumberFormatException e) {
				throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Erro de Conversao da Assina", "Assina invalida."));
			}
		} else
			return null;
	}
	
	public String getAsString1(FacesContext fc, UIComponent uic, Object object) {
		if (object != null) {
			return String.valueOf(((Participacao) object).getId());
		} else
			return null;
	}


	@FacesConverter(value = "modalidadeSubEvento")
	public ModalidadeSubEvento getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null && value.trim().length() > 0) {
			try {
				EntityManager em = JpaUtil.getInstance().getEntityManager();
				ModalidadeSubEvento ret = em.find(ModalidadeSubEvento.class, Long.parseLong(value));
				em.close();
				return ret;
			} catch (NumberFormatException e) {
				throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Erro de Conversao da Assina", "Assina invalida."));
			}
		} else
			return null;
	}
	

	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
		if (object != null) {
			return String.valueOf(((ModalidadeSubEvento) object).getId());
		} else
			return null;
	}

}
