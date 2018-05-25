package edu.ucam.tags;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

public class ControlAccesoTag extends BodyTagSupport {

	@Override
	public int doStartTag() throws JspException {

		if (this.pageContext.getSession().getAttribute("USER_LOGGED") != null) {
			return Tag.EVAL_BODY_INCLUDE;
		} else {
			try {
				pageContext.forward("/index.jsp");
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return Tag.SKIP_BODY;
		}

	}

}
