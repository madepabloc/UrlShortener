dataSource {  //Default datasource MYSQL
    pooled = true
    driverClassName = "com.mysql.jdbc.Driver"
    dialect = org.hibernate.dialect.MySQL5InnoDBDialect
    dbCreate = "validate"
}

hibernate {
    cache.use_second_level_cache = false
    cache.use_query_cache = false
    //cache.provider_class = 'net.sf.ehcache.hibernate.EhCacheProvider'
}


environments {
    development {
        dataSource {  //Default datasource MYSQL
            pooled = true
            driverClassName = "com.mysql.jdbc.Driver"
            dbCreate = 'create-drop'
            username = 'root'
            password = ''
            url = "jdbc:mysql://127.0.0.1:3306/urlShortener?useUnicode=true&characterEncoding=UTF-8"
            dialect = org.hibernate.dialect.MySQL5InnoDBDialect

            properties {
                maxActive = 80
                maxIdle = 40
                minIdle = 10
                initialSize = 10
                minEvictableIdleTimeMillis = 120000
                timeBetweenEvictionRunsMillis = 120000
                maxWait = 10000
                testOnBorrow = true
                testWhileIdle = true
                validationQuery = "select 1"
                removeAbandoned = true
                removeAbandonedTimeout = 600
                logAbandoned = true
            }

        }
    }


}
