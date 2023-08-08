package com.example.no9_progress_be.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseSuccess<T>  {
    private boolean success = true;
    private T data;
}
