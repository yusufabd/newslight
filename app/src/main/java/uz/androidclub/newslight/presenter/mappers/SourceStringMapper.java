package uz.androidclub.newslight.presenter.mappers;

import java.util.List;

import rx.Observable;
import rx.functions.Func1;
import uz.androidclub.newslight.presenter.vo.Source;
import uz.androidclub.newslight.retro.response.models.SourceDTO;

/**
 * Created by yusufabd on 4/26/2017.
 */

public class SourceStringMapper implements Func1<List<SourceDTO>, List<String>> {

    @Override
    public List<String> call(List<SourceDTO> sourceDTOs) {
        if (sourceDTOs == null)
            return null;

        return Observable.from(sourceDTOs)
                .map(sourceDTO -> new Source(sourceDTO.getId(), sourceDTO.getName(), sourceDTO.getSortBysAvailable()))
                .map(Source::getName)
                .toList()
                .toBlocking()
                .first();

    }
}
