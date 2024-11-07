package main

import (
	"testing"
	"time"

	"snippetbox.shahrullohon.net/internal/assert"
)

func TestHumanDate(t *testing.T) {
	tests := []struct {
		name string
		tm   time.Time
		want string
	}{
		{
			name: "UTC",
			tm:   time.Date(2024, 11, 5, 9, 30, 0, 0, time.UTC),
			want: "05 Nov 2024 at 09:30",
		},
		{
			name: "Empty",
			tm:   time.Time{},
			want: "",
		},
		{
			name: "CET",
			tm:   time.Date(2024, 11, 5, 9, 30, 0, 0, time.FixedZone("CET", 1*60*60)),
			want: "05 Nov 2024 at 08:30",
		},
	}

	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			hd := humanDate(tt.tm)

			assert.Equal(t, hd, tt.want)
		})
	}
}
