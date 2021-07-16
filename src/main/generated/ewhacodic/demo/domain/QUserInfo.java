package ewhacodic.demo.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserInfo is a Querydsl query type for UserInfo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserInfo extends EntityPathBase<UserInfo> {

    private static final long serialVersionUID = 721943647L;

    public static final QUserInfo userInfo = new QUserInfo("userInfo");

    public final StringPath auth = createString("auth");

    public final NumberPath<Long> code = createNumber("code", Long.class);

    public final StringPath password = createString("password");

    public final SetPath<Long, NumberPath<Long>> tagIds = this.<Long, NumberPath<Long>>createSet("tagIds", Long.class, NumberPath.class, PathInits.DIRECT2);

    public final StringPath userId = createString("userId");

    public QUserInfo(String variable) {
        super(UserInfo.class, forVariable(variable));
    }

    public QUserInfo(Path<? extends UserInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserInfo(PathMetadata metadata) {
        super(UserInfo.class, metadata);
    }

}

