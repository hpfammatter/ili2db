package ch.ehi.ili2db;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Assert;
import org.junit.Test;

import ch.ehi.ili2db.base.Ili2db;
import ch.ehi.ili2db.gui.Config;
import ch.ehi.sqlgen.DbUtility;

public abstract class Enum23Test {
    protected static final String TEST_OUT="test/data/Enum23/";
    protected AbstractTestSetup setup=createTestSetup();
    protected abstract AbstractTestSetup createTestSetup() ;

    @Test
    public void createScriptFromIliFkTable() throws Exception
    {
        Connection jdbcConnection=null;
        try{
            setup.resetDb();
            File data=new File(TEST_OUT,"Enum23b.ili");
            File outfile=new File(data.getPath()+"-out.sql");
            Config config=setup.initConfig(data.getPath(),data.getPath()+".log");
            config.setFunction(Config.FC_SCHEMAIMPORT);
            config.setCreateFk(Config.CREATE_FK_YES);
            config.setCreateNumChecks(true);
            config.setTidHandling(Config.TID_HANDLING_PROPERTY);
            config.setBasketHandling(Config.BASKET_HANDLING_READWRITE);
            config.setCreateMetaInfo(true);
            config.setCreateEnumDefs(Config.CREATE_ENUM_DEFS_MULTI_WITH_ID);
            config.setCatalogueRefTrafo(null);
            config.setMultiSurfaceTrafo(null);
            config.setMultilingualTrafo(null);
            config.setInheritanceTrafo(null);
            config.setCreatescript(outfile.getPath());
            Ili2db.run(config,null);
            
            // verify generated script
            {
                setup.resetDb();
                jdbcConnection=setup.createDbSchema();
                jdbcConnection.setAutoCommit(false);
                // execute generated script
                DbUtility.executeSqlScript(jdbcConnection, new java.io.FileReader(outfile));

                jdbcConnection.commit();
                {
                    Statement stmt=null;
                    String stmtTxt="select count(*) from "+setup.prefixName("enum1")+" where iliCode='Test1' and thisClass='Enum23b.Enum1' and baseClass is NULL";
                    try{
                        stmt=jdbcConnection.createStatement();
                         Assert.assertTrue(stmt.execute(stmtTxt));
                         ResultSet rs=stmt.getResultSet();
                         {
                             Assert.assertTrue(rs.next());
                             Assert.assertEquals(1, rs.getInt(1));
                         }
                    }finally {
                        if(stmt!=null) {
                            stmt.close();
                        }
                    }
                }
                jdbcConnection.close();
                jdbcConnection=null;
                
                {
                    // rum import without schema generation
                    data=new File(TEST_OUT,"Enum23b.xtf");
                    config.setXtffile(data.getPath());
                    config.setFunction(Config.FC_IMPORT);
                    config.setDoImplicitSchemaImport(false);
                    config.setCreatescript(null);
                    Ili2db.readSettingsFromDb(config);
                    Ili2db.run(config,null);
                    
                }
                
            }
            
        }finally{
            if(jdbcConnection!=null){
                jdbcConnection.close();
                jdbcConnection=null;
            }
        }   
    }
    @Test
    public void createScriptFromIliFkTableScriptOnly() throws Exception
    {
        Connection jdbcConnection=null;
        try{
            File data=new File(TEST_OUT,"Enum23b.ili");
            File outfile=new File(data.getPath()+"-out.sql");
            Config config=setup.initConfig(data.getPath(),data.getPath()+".log");
            config.setFunction(Config.FC_SCRIPT);
            config.setCreateFk(Config.CREATE_FK_YES);
            config.setCreateNumChecks(true);
            config.setTidHandling(Config.TID_HANDLING_PROPERTY);
            config.setBasketHandling(Config.BASKET_HANDLING_READWRITE);
            config.setCreateMetaInfo(true);
            config.setCreateEnumDefs(Config.CREATE_ENUM_DEFS_MULTI_WITH_ID);
            config.setCatalogueRefTrafo(null);
            config.setMultiSurfaceTrafo(null);
            config.setMultilingualTrafo(null);
            config.setInheritanceTrafo(null);
            config.setCreatescript(outfile.getPath());
            Ili2db.run(config,null);
            
            // verify generated script
            {
                setup.resetDb();
                jdbcConnection=setup.createDbSchema();
                jdbcConnection.setAutoCommit(false);
                // execute generated script
                DbUtility.executeSqlScript(jdbcConnection, new java.io.FileReader(outfile));

                jdbcConnection.commit();
                {
                    Statement stmt=null;
                    String stmtTxt="select count(*) from "+setup.prefixName("enum1")+" where iliCode='Test1' and thisClass='Enum23b.Enum1' and baseClass is NULL";
                    try{
                        stmt=jdbcConnection.createStatement();
                         Assert.assertTrue(stmt.execute(stmtTxt));
                         ResultSet rs=stmt.getResultSet();
                         {
                             Assert.assertTrue(rs.next());
                             Assert.assertEquals(1, rs.getInt(1));
                         }
                    }finally {
                        if(stmt!=null) {
                            stmt.close();
                        }
                    }
                }
                jdbcConnection.close();
                jdbcConnection=null;
                
                {
                    // rum import without schema generation
                    data=new File(TEST_OUT,"Enum23b.xtf");
                    config.setXtffile(data.getPath());
                    config.setFunction(Config.FC_IMPORT);
                    config.setDoImplicitSchemaImport(false);
                    config.setCreatescript(null);
                    Ili2db.readSettingsFromDb(config);
                    Ili2db.run(config,null);
                    
                }
                
            }
            
        }finally{
            if(jdbcConnection!=null){
                jdbcConnection.close();
                jdbcConnection=null;
            }
        }   
    }
    @Test
    public void createScriptFromIliSingleTable() throws Exception
    {
        Connection jdbcConnection=null;
        try{
            setup.resetDb();
            File data=new File(TEST_OUT,"Enum23b.ili");
            File outfile=new File(data.getPath()+"-out.sql");
            Config config=setup.initConfig(data.getPath(),data.getPath()+".log");
            config.setFunction(Config.FC_SCHEMAIMPORT);
            config.setCreateFk(Config.CREATE_FK_YES);
            config.setCreateNumChecks(true);
            config.setTidHandling(Config.TID_HANDLING_PROPERTY);
            config.setBasketHandling(Config.BASKET_HANDLING_READWRITE);
            config.setCreateMetaInfo(true);
            config.setCreateEnumDefs(Config.CREATE_ENUM_DEFS_SINGLE);
            config.setCatalogueRefTrafo(null);
            config.setMultiSurfaceTrafo(null);
            config.setMultilingualTrafo(null);
            config.setInheritanceTrafo(null);
            config.setCreatescript(outfile.getPath());
            Ili2db.run(config,null);
            
            // verify generated script
            {
                setup.resetDb();
                jdbcConnection=setup.createDbSchema();
                jdbcConnection.setAutoCommit(false);
                // execute generated script
                DbUtility.executeSqlScript(jdbcConnection, new java.io.FileReader(outfile));

                jdbcConnection.commit();
                jdbcConnection.close();
                jdbcConnection=null;
                
                {
                    // rum import without schema generation
                    data=new File(TEST_OUT,"Enum23b.xtf");
                    config.setXtffile(data.getPath());
                    config.setFunction(Config.FC_IMPORT);
                    config.setDoImplicitSchemaImport(false);
                    config.setCreatescript(null);
                    Ili2db.readSettingsFromDb(config);
                    Ili2db.run(config,null);
                    
                }
                
            }
            
        }finally{
            if(jdbcConnection!=null){
                jdbcConnection.close();
                jdbcConnection=null;
            }
        }   
    }
    @Test
    public void createScriptFromIliSingleTableScriptOnly() throws Exception
    {
        Connection jdbcConnection=null;
        try{
            File data=new File(TEST_OUT,"Enum23b.ili");
            File outfile=new File(data.getPath()+"-out.sql");
            Config config=setup.initConfig(data.getPath(),data.getPath()+".log");
            config.setFunction(Config.FC_SCRIPT);
            config.setCreateFk(Config.CREATE_FK_YES);
            config.setCreateNumChecks(true);
            config.setTidHandling(Config.TID_HANDLING_PROPERTY);
            config.setBasketHandling(Config.BASKET_HANDLING_READWRITE);
            config.setCreateMetaInfo(true);
            config.setCreateEnumDefs(Config.CREATE_ENUM_DEFS_SINGLE);
            config.setCatalogueRefTrafo(null);
            config.setMultiSurfaceTrafo(null);
            config.setMultilingualTrafo(null);
            config.setInheritanceTrafo(null);
            config.setCreatescript(outfile.getPath());
            Ili2db.run(config,null);
            
            // verify generated script
            {
                setup.resetDb();
                jdbcConnection=setup.createDbSchema();
                jdbcConnection.setAutoCommit(false);
                // execute generated script
                DbUtility.executeSqlScript(jdbcConnection, new java.io.FileReader(outfile));

                jdbcConnection.commit();
                jdbcConnection.close();
                jdbcConnection=null;
                
                {
                    // rum import without schema generation
                    data=new File(TEST_OUT,"Enum23b.xtf");
                    config.setXtffile(data.getPath());
                    config.setFunction(Config.FC_IMPORT);
                    config.setDoImplicitSchemaImport(false);
                    config.setCreatescript(null);
                    Ili2db.readSettingsFromDb(config);
                    Ili2db.run(config,null);
                    
                }
                
            }
            
        }finally{
            if(jdbcConnection!=null){
                jdbcConnection.close();
                jdbcConnection=null;
            }
        }   
    }
    @Test
    public void createScriptFromIliMultiTable() throws Exception
    {
        Connection jdbcConnection=null;
        try{
            setup.resetDb();
            File data=new File(TEST_OUT,"Enum23b.ili");
            File outfile=new File(data.getPath()+"-out.sql");
            Config config=setup.initConfig(data.getPath(),data.getPath()+".log");
            config.setFunction(Config.FC_SCHEMAIMPORT);
            config.setCreateFk(Config.CREATE_FK_YES);
            config.setCreateNumChecks(true);
            config.setTidHandling(Config.TID_HANDLING_PROPERTY);
            config.setBasketHandling(Config.BASKET_HANDLING_READWRITE);
            config.setCreateMetaInfo(true);
            config.setCreateEnumDefs(Config.CREATE_ENUM_DEFS_MULTI);
            config.setCatalogueRefTrafo(null);
            config.setMultiSurfaceTrafo(null);
            config.setMultilingualTrafo(null);
            config.setInheritanceTrafo(null);
            config.setCreatescript(outfile.getPath());
            Ili2db.run(config,null);
            
            // verify generated script
            {
                setup.resetDb();
                jdbcConnection=setup.createDbSchema();
                jdbcConnection.setAutoCommit(false);
                // execute generated script
                DbUtility.executeSqlScript(jdbcConnection, new java.io.FileReader(outfile));

                jdbcConnection.commit();
                jdbcConnection.close();
                jdbcConnection=null;
                
                {
                    // rum import without schema generation
                    data=new File(TEST_OUT,"Enum23b.xtf");
                    config.setXtffile(data.getPath());
                    config.setFunction(Config.FC_IMPORT);
                    config.setDoImplicitSchemaImport(false);
                    config.setCreatescript(null);
                    Ili2db.readSettingsFromDb(config);
                    Ili2db.run(config,null);
                    
                }
                
            }
            
        }finally{
            if(jdbcConnection!=null){
                jdbcConnection.close();
                jdbcConnection=null;
            }
        }   
    }
    @Test
    public void createScriptFromIliMultiTableScriptOnly() throws Exception
    {
        Connection jdbcConnection=null;
        try{
            File data=new File(TEST_OUT,"Enum23b.ili");
            File outfile=new File(data.getPath()+"-out.sql");
            Config config=setup.initConfig(data.getPath(),data.getPath()+".log");
            config.setFunction(Config.FC_SCRIPT);
            config.setCreateFk(Config.CREATE_FK_YES);
            config.setCreateNumChecks(true);
            config.setTidHandling(Config.TID_HANDLING_PROPERTY);
            config.setBasketHandling(Config.BASKET_HANDLING_READWRITE);
            config.setCreateMetaInfo(true);
            config.setCreateEnumDefs(Config.CREATE_ENUM_DEFS_MULTI);
            config.setCatalogueRefTrafo(null);
            config.setMultiSurfaceTrafo(null);
            config.setMultilingualTrafo(null);
            config.setInheritanceTrafo(null);
            config.setCreatescript(outfile.getPath());
            Ili2db.run(config,null);
            
            // verify generated script
            {
                setup.resetDb();
                jdbcConnection=setup.createDbSchema();
                jdbcConnection.setAutoCommit(false);
                // execute generated script
                DbUtility.executeSqlScript(jdbcConnection, new java.io.FileReader(outfile));

                jdbcConnection.commit();
                jdbcConnection.close();
                jdbcConnection=null;
                
                {
                    // rum import without schema generation
                    data=new File(TEST_OUT,"Enum23b.xtf");
                    config.setXtffile(data.getPath());
                    config.setFunction(Config.FC_IMPORT);
                    config.setDoImplicitSchemaImport(false);
                    config.setCreatescript(null);
                    Ili2db.readSettingsFromDb(config);
                    Ili2db.run(config,null);
                    
                }
                
            }
            
        }finally{
            if(jdbcConnection!=null){
                jdbcConnection.close();
                jdbcConnection=null;
            }
        }   
    }
}
