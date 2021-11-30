package gr;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.35.0)",
    comments = "Source: CasesService.proto")
public final class CasesServiceGrpc {

  private CasesServiceGrpc() {}

  public static final String SERVICE_NAME = "gr.CasesService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<gr.request,
      gr.Empty> getCollectCasesDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "collectCasesData",
      requestType = gr.request.class,
      responseType = gr.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<gr.request,
      gr.Empty> getCollectCasesDataMethod() {
    io.grpc.MethodDescriptor<gr.request, gr.Empty> getCollectCasesDataMethod;
    if ((getCollectCasesDataMethod = CasesServiceGrpc.getCollectCasesDataMethod) == null) {
      synchronized (CasesServiceGrpc.class) {
        if ((getCollectCasesDataMethod = CasesServiceGrpc.getCollectCasesDataMethod) == null) {
          CasesServiceGrpc.getCollectCasesDataMethod = getCollectCasesDataMethod =
              io.grpc.MethodDescriptor.<gr.request, gr.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "collectCasesData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  gr.request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  gr.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new CasesServiceMethodDescriptorSupplier("collectCasesData"))
              .build();
        }
      }
    }
    return getCollectCasesDataMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CasesServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CasesServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CasesServiceStub>() {
        @java.lang.Override
        public CasesServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CasesServiceStub(channel, callOptions);
        }
      };
    return CasesServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CasesServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CasesServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CasesServiceBlockingStub>() {
        @java.lang.Override
        public CasesServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CasesServiceBlockingStub(channel, callOptions);
        }
      };
    return CasesServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CasesServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CasesServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CasesServiceFutureStub>() {
        @java.lang.Override
        public CasesServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CasesServiceFutureStub(channel, callOptions);
        }
      };
    return CasesServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class CasesServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void collectCasesData(gr.request request,
        io.grpc.stub.StreamObserver<gr.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCollectCasesDataMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCollectCasesDataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                gr.request,
                gr.Empty>(
                  this, METHODID_COLLECT_CASES_DATA)))
          .build();
    }
  }

  /**
   */
  public static final class CasesServiceStub extends io.grpc.stub.AbstractAsyncStub<CasesServiceStub> {
    private CasesServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CasesServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CasesServiceStub(channel, callOptions);
    }

    /**
     */
    public void collectCasesData(gr.request request,
        io.grpc.stub.StreamObserver<gr.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCollectCasesDataMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CasesServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<CasesServiceBlockingStub> {
    private CasesServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CasesServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CasesServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public gr.Empty collectCasesData(gr.request request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCollectCasesDataMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CasesServiceFutureStub extends io.grpc.stub.AbstractFutureStub<CasesServiceFutureStub> {
    private CasesServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CasesServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CasesServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<gr.Empty> collectCasesData(
        gr.request request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCollectCasesDataMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_COLLECT_CASES_DATA = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CasesServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CasesServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_COLLECT_CASES_DATA:
          serviceImpl.collectCasesData((gr.request) request,
              (io.grpc.stub.StreamObserver<gr.Empty>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class CasesServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CasesServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return gr.CasesServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CasesService");
    }
  }

  private static final class CasesServiceFileDescriptorSupplier
      extends CasesServiceBaseDescriptorSupplier {
    CasesServiceFileDescriptorSupplier() {}
  }

  private static final class CasesServiceMethodDescriptorSupplier
      extends CasesServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CasesServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CasesServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CasesServiceFileDescriptorSupplier())
              .addMethod(getCollectCasesDataMethod())
              .build();
        }
      }
    }
    return result;
  }
}
