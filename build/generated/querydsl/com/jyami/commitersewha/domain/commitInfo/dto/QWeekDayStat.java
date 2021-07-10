package com.jyami.commitersewha.domain.commitInfo.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.Generated;

/**
 * com.jyami.commitersewha.domain.commitInfo.dto.QWeekDayStat is a Querydsl Projection type for WeekDayStat
 */
@Generated("com.querydsl.codegen.ProjectionSerializer")
public class QWeekDayStat extends ConstructorExpression<WeekDayStat> {

    private static final long serialVersionUID = -2038524211L;

    public QWeekDayStat(com.querydsl.core.types.Expression<Long> count, com.querydsl.core.types.Expression<Integer> weekDay) {
        super(WeekDayStat.class, new Class<?>[]{long.class, int.class}, count, weekDay);
    }

}

