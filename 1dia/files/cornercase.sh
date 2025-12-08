#!/bin/bash
set -euo pipefail

input_file="${1:-}"

if [[ -z "$input_file" || ! -f "$input_file" ]]; then
    echo "Usage: $0 <input_file>"
    exit 1
fi

# helper to run the java program with the current args and then clear args
run_and_clear_args() {
    if [[ ${#args[@]} -gt 0 ]]; then
        echo "Running: java ../src/Decoder.java ${args[*]}"
        java ../src/Decoder.java "${args[@]}"
        echo ""
        args=()
    fi
}

args=()
current_label=""

# read preserves blank lines; the '|| [ -n "$line" ]' ensures last line is processed if file doesn't end with newline
while IFS= read -r line || [ -n "$line" ]; do

    # ignore section headers starting with "##"
    if [[ "$line" == "#!"* ]]; then
        continue
    fi

    # label lines starting with a single '#' (possibly with no space)
    if [[ "$line" == "#"* ]]; then
        # if any args accumulated for previous block, run them before switching labels
        run_and_clear_args

        # print the label (strip leading '#', then trim leading/trailing whitespace)
        label="${line#\#}"
        # trim leading/trailing whitespace
        label="${label#"${label%%[![:space:]]*}"}"
        label="${label%"${label##*[![:space:]]}"}"
        echo "$label"
        current_label="$label"
        continue
    fi

    # if line is blank (only whitespace), treat it as a separator: run collected args, but keep the same label
    if [[ -z "${line//[[:space:]]/}" ]]; then
        run_and_clear_args
        continue
    fi

    # non-empty, non-comment line -> treat as argument for current test case
    args+=("$line")

done < "$input_file"

# run any final pending args after EOF
run_and_clear_args
