package br.com.grabriellpa.casesapi.v1.proto.service;

import br.com.grabriellpa.casesapi.v1.enums.CasesEnum;
import br.com.grabriellpa.casesapi.v1.service.CasesService;
import gr.CasesServiceGrpc;
import gr.Empty;
import gr.request;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;


@GrpcService
@RequiredArgsConstructor
public class CasesServiceImpl extends CasesServiceGrpc.CasesServiceImplBase {

    private final CasesService casesService;

    /**
     * Inicia a coleta de dados
     *
     * @param request Request recebida de um client
     * @param responseObserver Recebe/envia eventos.
     */
    @Override
    public void collectCasesData(request request, StreamObserver<Empty> responseObserver) {
        casesService.processData(CasesEnum.valueOf(request.getCasesType().name()));
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }
}
