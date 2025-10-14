package click.dailyfeed.pagination.mapper;

import click.dailyfeed.code.global.web.page.DailyfeedPage;
import click.dailyfeed.code.global.web.page.DailyfeedScrollPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;
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

    public <D, T> DailyfeedScrollPage<T> fromJpaSliceToDailyfeedScrollPage(Slice<D> slice, List<T> result) {
        return DailyfeedScrollPage.<T>builder()
                .content(result)
                .page(slice.getNumber())
                .size(slice.getSize())
                .build();
    }

    public <D, T> DailyfeedPage<T> fromJpaPageToDailyfeedPage(Page<D> page, List<T> content) {
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

    public <T> DailyfeedScrollPage<T> emptyScrollPage(){
        return DailyfeedScrollPage.<T>builder()
                .content(List.of())
                .page(0)
                .size(0)
                .build();
    }

    public <T> DailyfeedPage<T> emptyPage(){
        return DailyfeedPage.<T>builder()
                .content(List.of())
                .page(0)
                .size(0)
                .totalElements(0)
                .totalPages(0)
                .isFirst(true)
                .isLast(true)
                .hasNext(false)
                .hasPrevious(false)
                .build();
    }
}
