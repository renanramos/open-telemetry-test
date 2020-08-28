/**
 * 
 */
package com.renanrramos.opentelemetrytest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.opentelemetry.OpenTelemetry;
import io.opentelemetry.exporters.logging.LoggingSpanExporter;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.trace.SpanProcessor;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
import io.opentelemetry.trace.Tracer;

/**
 * @author renan.ramos
 *
 */
@Configuration
public class OpenTelemetryConfig {

	private static final String TRACER_NAME = "tracer";

	@Bean
	public Tracer openTracer() {
		Tracer tracer = OpenTelemetry.getTracer(TRACER_NAME);

		SpanProcessor logProcessor = SimpleSpanProcessor.newBuilder(new LoggingSpanExporter()).build();
		OpenTelemetrySdk.getTracerProvider().addSpanProcessor(logProcessor);

		return tracer;
	}
	
}
