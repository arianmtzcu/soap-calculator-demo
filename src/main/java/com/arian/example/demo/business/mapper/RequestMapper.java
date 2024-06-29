package com.arian.example.demo.business.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingInheritanceStrategy;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.arian.example.demo.domain.dto.Members;
import com.arian.example.demo.interfaces.wsdl.Add;
import com.arian.example.demo.interfaces.wsdl.Divide;
import com.arian.example.demo.interfaces.wsdl.Multiply;
import com.arian.example.demo.interfaces.wsdl.Subtract;

@Mapper( //
      mappingInheritanceStrategy = MappingInheritanceStrategy.EXPLICIT, //
      nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,  //
      unmappedTargetPolicy = ReportingPolicy.WARN  //
)
public abstract class RequestMapper {

   public static RequestMapper INSTANCE = Mappers.getMapper(RequestMapper.class);

   @Mapping(target = "intA", expression = "java(members.getA())")
   @Mapping(target = "intB", expression = "java(members.getB())")
   public abstract Add toAddRequest(Members members);

   @Mapping(target = "intA", expression = "java(members.getA())")
   @Mapping(target = "intB", expression = "java(members.getB())")
   public abstract Subtract toSubtractRequest(Members members);

   @Mapping(target = "intA", expression = "java(members.getA())")
   @Mapping(target = "intB", expression = "java(members.getB())")
   public abstract Multiply toMultiplyRequest(Members members);

   @Mapping(target = "intA", expression = "java(members.getA())")
   @Mapping(target = "intB", expression = "java(members.getB())")
   public abstract Divide toDivideRequest(Members members);

}
