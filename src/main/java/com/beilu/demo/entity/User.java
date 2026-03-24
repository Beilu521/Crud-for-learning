package main.java.com.beilu.demo.entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class user {
    @TableId(Type=IdType.ASSIGN_ID)//雪花算法
    private Long id;
    private String username;
    private String nickname;
    private Integer age;
    private String email;
    private LocalDateTime createTime;//创建时间
    private LocalDateTime updateTime;//更新时间
}
