export interface Incident {
  id?: number;
  title: string;
  description: string;
  priority: 'LOW' | 'NORMAL' | 'HIGH' | 'CRITICAL';
  status: 'OPEN' | 'IN_PROGRESS' | 'RESOLVED' | 'CLOSED';
  createdAt?: string;
  updatedAt?: string;
}

export interface CreateIncidentRequest {
  title: string;
  description: string;
  priority: 'LOW' | 'NORMAL' | 'HIGH' | 'CRITICAL';
}

export interface StatusUpdateRequest {
  status: 'OPEN' | 'IN_PROGRESS' | 'RESOLVED' | 'CLOSED';
}
