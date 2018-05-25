package edu.ucam.tags;

import java.io.IOException;
import java.util.Hashtable;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import edu.ucam.beans.Curso;

public class CuentaCursosTag extends BodyTagSupport {

	@Override
	public int doStartTag() throws JspException {

		Hashtable<String, Curso> cursos = ((Hashtable<String, Curso>) this.pageContext.getServletContext()
				.getAttribute("CURSOS"));

		try {
			if (cursos == null) {
				this.pageContext.getOut().println("No existen cursos");
			} else {
				this.pageContext.getOut().println("Total de cursos: " + cursos.size());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return super.doStartTag();
	}

}
