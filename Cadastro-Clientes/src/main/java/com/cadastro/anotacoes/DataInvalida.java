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


@Pattern(regexp = "((0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/[12][0-9]{3})|((0[1-9]|[12][0-9]|3[01]).(0[1-9]|1[012]).[12][0-9]{3})")
@ReportAsSingleViolation
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Constraint(validatedBy = {})
public @interface DataInvalida {

	String message() default "{((0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/[12][0-9]{3})|((0[1-9]|[12][0-9]|3[01]).(0[1-9]|1[012]).[12][0-9]{3})";

	Protocolo protocolo() default Protocolo.VIOLACAO_DE_VALOR;

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
