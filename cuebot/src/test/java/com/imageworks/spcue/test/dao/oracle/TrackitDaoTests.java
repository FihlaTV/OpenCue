
/*
 * Copyright Contributors to the OpenCue Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */



package com.imageworks.spcue.test.dao.oracle;

import java.util.List;
import javax.annotation.Resource;

import org.junit.Rule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.imageworks.spcue.TrackitTaskDetail;
import com.imageworks.spcue.config.TestAppConfig;
import com.imageworks.spcue.dao.TrackitDao;
import com.imageworks.spcue.test.AssumingOracleEngine;
import com.imageworks.spcue.test.AssumingTrackitEnabled;

import static org.junit.Assert.assertTrue;

@ContextConfiguration(classes=TestAppConfig.class, loader=AnnotationConfigContextLoader.class)
public class TrackitDaoTests extends AbstractTransactionalJUnit4SpringContextTests  {

    @Autowired
    @Rule
    public AssumingOracleEngine assumingOracleEngine;

    @Autowired
    @Rule
    public AssumingTrackitEnabled assumingTrackitEnabled;

    @Resource
    TrackitDao trackitDao;

    @Test
    public void testGetTasks() {
        List<TrackitTaskDetail> result = trackitDao.getTasks("clo","Lighting");
        assertTrue(result.size() > 0);
    }
}

