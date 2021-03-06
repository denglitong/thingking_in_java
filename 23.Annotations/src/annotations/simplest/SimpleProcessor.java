package annotations.simplest;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import java.util.Set;

/**
 * @author 邓礼桐（denglitong.dlt@alibaba-inc.com）
 * @date 2021/2/8
 */
@SupportedAnnotationTypes("annotations.simplest.Simple")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class SimpleProcessor extends AbstractProcessor {
	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment env) {
		for (TypeElement t : annotations) {
			System.out.println(t);
		}
		for (Element element : env.getElementsAnnotatedWith(Simple.class)) {
			display(element);
		}
		return false;
	}

	private void display(Element el) {
		System.out.println("==== " + el + " ====");
		System.out.println(el.getKind() +
				" : " + el.getModifiers() +
				" : " + el.getSimpleName() +
				" : " + el.asType());
		if (el.getKind().equals(ElementKind.CLASS)) {
			TypeElement te = (TypeElement) el;
			System.out.println(te.getQualifiedName());
			System.out.println(te.getSuperclass());
			System.out.println(te.getEnclosedElements());
		}
		if (el.getKind().equals(ElementKind.METHOD)) {
			ExecutableElement ex = (ExecutableElement) el;
			System.out.print(ex.getReturnType() + " ");
			System.out.print(ex.getSimpleName() + "(");
			System.out.println(ex.getParameters() + ")");
		}
	}
}
