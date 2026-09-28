package ucb.zubieta.project.PruebasGenerales.data.mapper

import ucb.zubieta.project.PruebasGenerales.data.dto.MovieInfoDto
import ucb.zubieta.project.PruebasGenerales.domain.model.MovieInfoModel

fun MovieInfoDto.toModel(): MovieInfoModel{
    return MovieInfoModel(title=title,posterPath=posterPath)
}

