#!/bin/bash
input_decoder="$1"
input_file="$2"
input_data=$(tr '\n' ' ' < $input_file)
java $input_decoder $input_data
