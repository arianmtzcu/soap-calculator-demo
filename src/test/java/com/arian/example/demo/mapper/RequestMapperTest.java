package com.arian.example.demo.mapper;


import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import com.arian.example.demo.business.mapper.RequestMapper;
import com.arian.example.demo.domain.dto.Members;

class RequestMapperTest {

   @Test
   public void givenMemberRequest_whenMaps_thenCorrect() {
      final var members = Members.builder().a(1).b(2).build();
      final var add = RequestMapper.INSTANCE.toAddRequest(members);
      assertEquals(add.getIntA(), members.getA());
      assertEquals(add.getIntB(), members.getB());
   }

}