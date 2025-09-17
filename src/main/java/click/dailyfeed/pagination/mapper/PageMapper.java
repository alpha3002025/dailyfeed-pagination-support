package click.dailyfeed.pagination.mapper;

import click.dailyfeed.code.global.web.response.DailyfeedPage;
import click.dailyfeed.code.global.web.response.DailyfeedScrollPage;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PageMapper {
    public <D, T> DailyfeedScrollPage<T> fromJpaPageToDailyfeedScrollPage(Page<D> page, List<T> result) {
        return DailyfeedScrollPage.<T>builder()
                .content(result)
                .page(page.getNumber())
                .size(page.getSize())
                .build();
    }

    public <D, T>DailyfeedPage<T> fromJpaPageToDailyfeedPage(Page<D> page, List<T> content) {
        return DailyfeedPage.<T>builder()
                .content(content)
                .page(page.getNumber())
                .size(page.getSize())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .isFirst(page.isFirst())
                .isLast(page.isLast())
                .hasNext(page.hasNext())
                .hasPrevious(page.hasPrevious())
                .build();
    }
}
