package com.jyami.commitersewha.domain.commitInfo.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.Generated;

/**
 * com.jyami.commitersewha.domain.commitInfo.dto.QHourStat is a Querydsl Projection type for HourStat
 */
@Generated("com.querydsl.codegen.ProjectionSerializer")
public class QHourStat extends ConstructorExpression<HourStat> {

    private static final long serialVersionUID = 1236065959L;

    public QHourStat(com.querydsl.core.types.Expression<Long> count, com.querydsl.core.types.Expression<Integer> hour) {
        super(HourStat.class, new Class<?>[]{long.class, int.class}, count, hour);
    }

}

