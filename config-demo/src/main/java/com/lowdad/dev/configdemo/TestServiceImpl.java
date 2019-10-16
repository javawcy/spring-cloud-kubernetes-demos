package com.lowdad.dev.configdemo;

import com.lowdad.dev.rpc.Test;
import com.lowdad.dev.rpc.TestServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

import java.io.*;

/**
 * @author lowdad
 * 2019-10-16
 **/
@GrpcService
@Slf4j
public class TestServiceImpl extends TestServiceGrpc.TestServiceImplBase {
    @Override
    public void test(Test.Req request, StreamObserver<Test.Res> responseObserver) {
        File file = new File("/Users/javawcy/test.jpg");
        try {
            OutputStream stream = new FileOutputStream(file);
            stream.write(request.getPic().toByteArray());
            stream.flush();
            stream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        log.info("msg:{}",request.getMsg());

        Test.Res res = Test.Res.newBuilder()
                .setMsg("msg received")
                .build();

        responseObserver.onNext(res);
        responseObserver.onCompleted();
    }
}
