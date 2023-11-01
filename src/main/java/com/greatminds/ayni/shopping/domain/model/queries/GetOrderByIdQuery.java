package com.greatminds.ayni.shopping.domain.model.queries;

import lombok.Getter;

@Getter
public record GetOrderByIdQuery(Long orderId) {}
