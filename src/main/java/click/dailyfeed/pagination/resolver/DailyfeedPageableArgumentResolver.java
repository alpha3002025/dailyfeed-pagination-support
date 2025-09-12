package click.dailyfeed.pagination.resolver;

import click.dailyfeed.code.global.web.page.DailyfeedPageable;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class DailyfeedPageableArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(DailyfeedPageable.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {
        String pageStr = webRequest.getParameter("page");
        String sizeStr = webRequest.getParameter("size");
        String sort = webRequest.getParameter("sort");

        int page = pageStr != null ? Integer.parseInt(pageStr) : 0;
        int size = sizeStr != null ? Integer.parseInt(sizeStr) : 10;

//        return DailyfeedPageable.of(page, size, sort);
        return DailyfeedPageable.allArgsBuilder()
                .page(page)
                .size(size)
                .sort(sort)
                .build();
    }
}
