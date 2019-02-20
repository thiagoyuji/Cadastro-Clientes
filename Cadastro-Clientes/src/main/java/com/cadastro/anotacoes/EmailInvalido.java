package com.cadastro.anotacoes;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Pattern;

import com.cadastro.protocolos.Protocolo;


@Pattern(regexp = "[a-zA-Z0-9._\\-,#!$%*&\\(\\)\\{\\\\}\\[\\]\\+=:;/?><]+@[a-zA-Z0-9._\\-,#!$%*&\\(\\)\\{\\\\}\\[\\]\\+=:;/?><]+")
@ReportAsSingleViolation
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Constraint(validatedBy = {})
public @interface EmailInvalido {

	String message() default "{[a-zA-Z0-9._\\-,#!$%*&\\(\\)\\{\\\\}\\[\\]\\+=:;/?><]+@[a-zA-Z0-9._\\-,#!$%*&\\(\\)\\{\\\\}\\[\\]\\+=:;/?><]+)";

	Protocolo protocolo() default Protocolo.VIOLACAO_DE_VALOR;

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
