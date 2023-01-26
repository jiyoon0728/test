package shop.mtcoding.jiyoon.model;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserRepository {

        public User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

        public int insert(@Param("username") String username,
                        @Param("password") String password,
                        @Param("email") String email);

        public int update(@Param("id") int id, @Param("username") String username,
                        @Param("password") String password,
                        @Param("email") String email);

}
