package generator.config;

import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * 默认的代码生成的配置
 *
 * @author fengshuonan
 * @date 2017-10-28-下午8:27
 */
public class GunsGeneratorConfig extends AbstractGeneratorConfig {

    @Override
    protected void globalConfig() {
        globalConfig.setOutputDir("F:/generator/guns/guns-admin/src/main/java");
        globalConfig.setFileOverride(true);
        globalConfig.setEnableCache(false);
        globalConfig.setBaseResultMap(true);
        globalConfig.setBaseColumnList(true);
        globalConfig.setOpen(false);
        globalConfig.setAuthor("weijx");
    }

    @Override
    protected void dataSourceConfig() {
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setDriverName("com.mysql.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("root");
        dataSourceConfig.setUrl("jdbc:mysql://47.95.254.244:3306/guns?characterEncoding=utf8");
    }

    @Override
    protected void strategyConfig() {
        //strategy.setTablePrefix(new String[]{"_"});// 此处可以修改为您的表前缀
        strategyConfig.setInclude(new String[]{"renovation"});
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
    }

    @Override
    protected void packageConfig() {
        packageConfig.setParent(null);
        packageConfig.setEntity("com.weilai.model");
        packageConfig.setMapper("com.weilai.dao");
        packageConfig.setXml("com.weilai.dao.mapping");
    }

    @Override
    protected void contextConfig() {
        contextConfig.setBizChName("装修");
        contextConfig.setBizEnName("renovation");
        contextConfig.setModuleName("weilai");
        contextConfig.setProjectPath("F:/generator/guns/guns-admin");
        contextConfig.setEntityName("renovation");
        sqlConfig.setParentMenuName("顶级");

        /**
         * mybatis-plus 生成器开关
         */
        contextConfig.setEntitySwitch(true);
        contextConfig.setDaoSwitch(true);
        contextConfig.setServiceSwitch(true);

        /**
         * guns 生成器开关
         */
        contextConfig.setControllerSwitch(true);
        contextConfig.setIndexPageSwitch(true);
        contextConfig.setAddPageSwitch(true);
        contextConfig.setEditPageSwitch(true);
        contextConfig.setJsSwitch(true);
        contextConfig.setInfoJsSwitch(true);
        contextConfig.setSqlSwitch(true);
    }
}
